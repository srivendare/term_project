/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui.analyse;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Category;
import model.DB_INFO;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.time.Month;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.time.TimeSeriesDataItem;
import org.jfree.data.xy.XYDataset;

/**
 *
 * @author gulinigeer
 */
public class Chart {
    Connection connection;
    
    public Chart(){}

    private CategoryDataset getDataSet() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        String query = "SELECT IFNULL(sum(d.quantity),0),c.`name` FROM\n" +
"category c\n" +
"LEFT JOIN product p ON p.category_id = c.id \n" +
"LEFT JOIN order_detail d ON p.id = d.product_id\n" +
"GROUP BY c.`name`;";
        try {
            ResultSet rs = queryDataResult(query);
            while(rs.next()){
           dataset.addValue(rs.getInt(1), rs.getString(2), rs.getString(2));     
            }
        } catch (Exception e) {
            Logger.getLogger(Chart.class.getName()).log(Level.SEVERE, null, e);
        }
        return dataset;
    }

    
    public ResultSet queryDataResult(String query){
        
        connection = DB_INFO.getConnection();
        ResultSet rs = null;
        PreparedStatement ps;

        
        try {

                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();
           
        } catch (SQLException ex) {
            Logger.getLogger(Category.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rs;
    }

    
public ChartPanel getSalesVolumeChart(){
    CategoryDataset dataset = getDataSet();
    Category c = new Category();
    c.populateCombo();
        JFreeChart chart = ChartFactory.createBarChart3D(
       		                 "Product Comparison Sales Chart", 
                            "Product Categories", 
                            "Sales quantity", 
                            dataset, 
                            PlotOrientation.VERTICAL, 
                            true,           
                            false,         
                            false          
                            );
        
        
        CategoryPlot plot=chart.getCategoryPlot();
        CategoryAxis domainAxis=plot.getDomainAxis();         
         domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));       
         domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  
         ValueAxis rangeAxis=plot.getRangeAxis();
         rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
          chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
          chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
          
          
         return new ChartPanel(chart,true);        
}

    public XYDataset createDataset(){
    
        TimeSeries timeseries = new TimeSeries("sales amount",org.jfree.data.time.Month.class);
    
        String query = "SELECT IFNULL(sum(d.total),0),DATE_FORMAT(t.`order_date`,'%Y-%m') FROM\n" +
"order_tbl t\n" +
"LEFT JOIN order_detail d ON t.id = d.order_id\n" +
"GROUP BY DATE_FORMAT(t.`order_date`,'%Y-%m');";
        try {
            ResultSet rs = queryDataResult(query);
            while(rs.next()){
                String[] date = rs.getString(2).split("-");
                timeseries.add(new Month(Integer.valueOf(date[1]),Integer.valueOf(date[0])),rs.getDouble(1));     
            }
        } catch (Exception e) {
            Logger.getLogger(Chart.class.getName()).log(Level.SEVERE, null, e);
        }
       
	TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
	timeseriescollection.addSeries(timeseries);
	return timeseriescollection;

    }

  public ChartPanel getAnaylysis(){
      
      XYDataset xydataset = createDataset();
		JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Sales over time graph", "date", "Total sales price",xydataset, true, true, true);
		XYPlot xyplot = (XYPlot) jfreechart.getPlot();
		DateAxis dateaxis = (DateAxis) xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        ChartPanel frame1=new ChartPanel(jfreechart,true);
        dateaxis.setLabelFont(new Font("黑体",Font.BOLD,14));       
        dateaxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  
        ValueAxis rangeAxis=xyplot.getRangeAxis();
        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));
        jfreechart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));
        jfreechart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
        return frame1;
   }
  
  public DefaultPieDataset getDataset(){
         DefaultPieDataset dataset = new DefaultPieDataset();
        String query = "SELECT IFNULL(sum(d.total),0),c.`name` FROM\n" +
"category c \n" +
"LEFT JOIN product p ON c.id = p.category_id\n" +
"LEFT JOIN order_detail d ON p.id = d.product_id\n" +
"LEFT JOIN order_tbl t ON t.id = d.order_id\n" +
"WHERE  DATE_FORMAT(t.`order_date`,'%Y-%m') <= '2022-12' \n" +
"AND  DATE_FORMAT(t.`order_date`,'%Y-%m') >= '2022-01' \n" +
"GROUP BY c.`name`;";
        try {
            ResultSet rs = queryDataResult(query);
            while(rs.next()){
           dataset.setValue(rs.getString(2), rs.getInt(1));     
            }
        } catch (Exception e) {
            Logger.getLogger(Chart.class.getName()).log(Level.SEVERE, null, e);
        }
        return dataset;
       
  
  }
  
  public ChartPanel getPercentage(){
  
              DefaultPieDataset data = getDataset();
	      JFreeChart chart = ChartFactory.createPieChart3D("Percentage of sales",data,true,false,false);
	    
	      PiePlot pieplot = (PiePlot) chart.getPlot();
	      DecimalFormat df = new DecimalFormat("0.00%");
	      NumberFormat nf = NumberFormat.getNumberInstance();
	      StandardPieSectionLabelGenerator sp1 = new StandardPieSectionLabelGenerator("{0}  {2}", nf, df);//获得StandardPieSectionLabelGenerator对象
	      pieplot.setLabelGenerator(sp1);
	  
	  
	      pieplot.setNoDataMessage("No Data");
	      pieplot.setCircular(false);
	      pieplot.setLabelGap(0.02D);
	  
	      pieplot.setIgnoreNullValues(true);
	      pieplot.setIgnoreZeroValues(true);
	     ChartPanel frame1=new ChartPanel (chart,true);
	      chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));
	      PiePlot piePlot= (PiePlot) chart.getPlot();
	      piePlot.setLabelFont(new Font("宋体",Font.BOLD,10));
	      chart.getLegend().setItemFont(new Font("黑体",Font.BOLD,10));
              return frame1;

  
  }
}

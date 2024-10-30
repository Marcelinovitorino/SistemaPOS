
package View;

/**
 *
 * @author wow
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.swing.JRViewer;
import Connection.ConnectionMySQL;

public class ReportView extends JFrame {

    public ReportView(String fileName) {
        this(fileName, null);
    }

   

    public ReportView(String fileName, HashMap para) {
        super("VOIDpay Print System");

        try {
           Connection con = ConnectionMySQL.getConnection();
            System.out.println(con);

            try {
                JasperPrint print = JasperFillManager.fillReport(fileName, para, con);
                JRViewer viewer = new JRViewer(print);
                Container c = getContentPane();
                c.add(viewer);
            } catch (JRException jRException) {
                System.out.println(jRException);
            }
            setBounds(2, 2, 900, 700);
            setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        } catch (SQLException ex) {
            Logger.getLogger(ReportView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    void print() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

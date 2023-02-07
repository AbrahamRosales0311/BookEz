import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class roiTable {
    private static tableWriter t = new tableWriter();//creating an instance of table writer

    /**
     * Creating the table and storing it within a JTable to be returned and used within the panel display
     * @return
     */
    public JTable getTable(){
        JTable table = new JTable(t);//creating table with tablewriter 

        table.setPreferredScrollableViewportSize(new Dimension(800, 500));//setting tables size 
        table.getColumnModel().getColumn(finalTableValues.checkCol).setCellRenderer(new checkBox());//rendering checkboxes 

        //adding mouse listener for each check box 
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                //obtaining each point on the table that was clicked
                int row = table.rowAtPoint(e.getPoint());
                int col = table.columnAtPoint(e.getPoint());
            
                if (col == finalTableValues.checkCol) {//if column is the check box column 
                    Object value = table.getValueAt(row, col);//obtain the current value 

                    if(value instanceof Boolean){//if it is a boolean
                        Boolean checked = (Boolean) value;//obtain boolean value
                        t.setValueAt(!checked, row, col);//setting the value to the opposite of what it currently is
                        table.repaint();//updating check box render 
                    }
                }
            }
        });
        return table;//returning the jtable

    }

    /**
     * Returning the table writer instance used for the abstract table
     * @return returning table writer 
     */
    public static tableWriter returnWriter(){
        return t;

    }

    /**
     * Deletes selected rows from table
     */
    public void deleteRows(){
        t.deletedSelectedRows();//making tableWriter function call
    }
}

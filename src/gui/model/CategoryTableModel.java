// 
// Decompiled by Procyon v0.5.30
// 

package gui.model;

import service.CategoryService;
import entity.Category;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class CategoryTableModel extends AbstractTableModel
{
    String[] columnNames;
    public List<Category> cs;
    
    public CategoryTableModel() {
        this.columnNames = new String[] { "\u5206\u7c7b\u540d\u79f0", "\u6d88\u8d39\u6b21\u6570" };
        this.cs = new CategoryService().list();
    }
    
    @Override
    public int getRowCount() {
        return this.cs.size();
    }
    
    @Override
    public int getColumnCount() {
        return this.columnNames.length;
    }
    
    @Override
    public String getColumnName(final int columnIndex) {
        return this.columnNames[columnIndex];
    }
    
    @Override
    public boolean isCellEditable(final int rowIndex, final int columnIndex) {
        return false;
    }
    
    @Override
    public Object getValueAt(final int rowIndex, final int columnIndex) {
        final Category h = this.cs.get(rowIndex);
        if (columnIndex == 0) {
            return h.name;
        }
        if (1 == columnIndex) {
            return h.recordNumber;
        }
        return null;
    }
}

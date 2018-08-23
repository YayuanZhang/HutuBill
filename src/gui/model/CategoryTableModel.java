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
        this.columnNames = new String[] { "分类名称", "消费次数" };
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

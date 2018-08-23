// 
// Decompiled by Procyon v0.5.30
// 

package gui.model;

import javax.swing.event.ListDataListener;
import service.CategoryService;
import java.util.List;
import entity.Category;
import javax.swing.ComboBoxModel;

public class CategoryComboBoxModel implements ComboBoxModel<Category>
{
    public List<Category> cs;
    public Category c;
    
    public CategoryComboBoxModel() {
        this.cs = new CategoryService().list();
        if (!this.cs.isEmpty()) {
            this.c = this.cs.get(0);
        }
    }
    
    @Override
    public int getSize() {
        return this.cs.size();
    }
    
    @Override
    public Category getElementAt(final int index) {
        return this.cs.get(index);
    }
    
    @Override
    public void addListDataListener(final ListDataListener l) {
    }
    
    @Override
    public void removeListDataListener(final ListDataListener l) {
    }
    
    @Override
    public void setSelectedItem(final Object anItem) {
        this.c = (Category)anItem;
    }
    
    @Override
    public Object getSelectedItem() {
        if (!this.cs.isEmpty()) {
            return this.c;
        }
        return null;
    }
}

// 
// Decompiled by Procyon v0.5.30
// 

package service;

import entity.Record;
import java.util.Iterator;
import java.util.Collections;
import entity.Category;
import java.util.List;
import dao.RecordDAO;
import dao.CategoryDAO;

public class CategoryService
{
    CategoryDAO categoryDao;
    RecordDAO recordDao;
    
    public CategoryService() {
        this.categoryDao = new CategoryDAO();
        this.recordDao = new RecordDAO();
    }
    
    public List<Category> list() {
        final List<Category> cs = this.categoryDao.list();
        for (final Category c3 : cs) {
            final List<Record> rs = this.recordDao.list(c3.id);
            c3.recordNumber = rs.size();
        }
        Collections.sort(cs, (c1, c2) -> c2.recordNumber - c1.recordNumber);
        return cs;
    }
    
    public void add(final String name) {
        final Category c = new Category();
        c.setName(name);
        this.categoryDao.add(c);
    }
    
    public void update(final int id, final String name) {
        final Category c = new Category();
        c.setName(name);
        c.setId(id);
        this.categoryDao.update(c);
    }
    
    public void delete(final int id) {
        this.categoryDao.delete(id);
    }
}

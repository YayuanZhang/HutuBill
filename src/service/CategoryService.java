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
    CategoryDAO categoryDao= new CategoryDAO();
    RecordDAO recordDao= new RecordDAO();
    
    public List<Category> list() {
       List<Category> cs = this.categoryDao.list();
        for ( Category c : cs) {
            List<Record> rs = this.recordDao.list(c.id);
            c.recordNumber = rs.size();
        }
        Collections.sort(cs, (c1, c2) -> c2.recordNumber - c1.recordNumber);
        return cs;
    }
    
    public void add(final String name) {
        Category c = new Category();
        c.setName(name);
        categoryDao.add(c);
    }
    
    public void update(final int id, final String name) {
        Category c = new Category();
        c.setName(name);
        c.setId(id);
        categoryDao.update(c);
    }
    
    public void delete(final int id) {
        categoryDao.delete(id);
    }
}

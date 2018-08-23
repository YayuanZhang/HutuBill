package entity;

public class Category
{
    public int id;
    public String name;
    public int recordNumber;
    
    public int getRecordNumber() {
        return this.recordNumber;
    }
    
    public void setRecordNumber(final int recordNumber) {
        this.recordNumber = recordNumber;
    }
    
    public int getId() {
        return this.id;
    }
    
    public void setId(final int id) {
        this.id = id;
    }
    
    public String getName() {
        return this.name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return this.name;
    }
}

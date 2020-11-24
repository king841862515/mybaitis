package cn.itsource.domain.many2one;


/**
 *   商品
 * @author admin
 *
 */
public class Product {	
	private Long   pid         ;
	private String pname       ;
	private Double price       ;
	private String flag        ;//上架
	//多对一的关系，建立对象
	private Category category    ;
	
	
	
	public Long getPid() {
		return pid;
	}
	public void setPid(Long pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", flag=" + flag + ", category="
				+ category + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
}

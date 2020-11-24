package cn.itsource.domain.one2many;

import java.util.ArrayList;
import java.util.List;

public class CategoryAlias {

	public CategoryAlias(Long cid, String cname) {
		super();// 这个是Java的规定：子类继承父类，子类的构造方法必须调用super（）即父类的构造方法，而且必须放在构造方法的第一行。那么问题又来，为什么我写的类有时候都不用去调用父类的构造方法？因为：如果父类"只"有无参构造方法，且不打算重写子类的构造方法，为节省代码量，子类构造方法可以不写，但是实际上是已经写了，系统默认调用父类无参构造方法super()，即默认会在子类的构造方法中的第一行加上父类的无参构造方法
		this.cid = cid;
		this.cname = cname;
	}

	public CategoryAlias() {
	}

	private List<ProductAlias> products = new ArrayList<>();

	private Long cid;
	private String cname;

	public Long getCid() {
		return cid;
	}

	public void setCid(Long cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public List<ProductAlias> getProducts() {
		return products;
	}

	public void setProducts(List<ProductAlias> products) {
		this.products = products;
	}

	@Override
	public String toString() {
		return "Category [products=" + products + ", cid=" + cid + ", cname=" + cname + "]";
	}

}

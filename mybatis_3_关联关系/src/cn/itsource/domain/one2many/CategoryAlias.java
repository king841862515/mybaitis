package cn.itsource.domain.one2many;

import java.util.ArrayList;
import java.util.List;

public class CategoryAlias {

	public CategoryAlias(Long cid, String cname) {
		super();// �����Java�Ĺ涨������̳и��࣬����Ĺ��췽���������super����������Ĺ��췽�������ұ�����ڹ��췽���ĵ�һ�С���ô����������Ϊʲô��д������ʱ�򶼲���ȥ���ø���Ĺ��췽������Ϊ���������"ֻ"���޲ι��췽�����Ҳ�������д����Ĺ��췽����Ϊ��ʡ�����������๹�췽�����Բ�д������ʵ�������Ѿ�д�ˣ�ϵͳĬ�ϵ��ø����޲ι��췽��super()����Ĭ�ϻ�������Ĺ��췽���еĵ�һ�м��ϸ�����޲ι��췽��
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

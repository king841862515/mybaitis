package cn.itsource.domain.many2one;

public class Category {

	public Category(Long cid, String cname) {
		super();// �����Java�Ĺ涨������̳и��࣬����Ĺ��췽���������super����������Ĺ��췽�������ұ�����ڹ��췽���ĵ�һ�С���ô����������Ϊʲô��д������ʱ�򶼲���ȥ���ø���Ĺ��췽������Ϊ���������"ֻ"���޲ι��췽�����Ҳ�������д����Ĺ��췽����Ϊ��ʡ�����������๹�췽�����Բ�д������ʵ�������Ѿ�д�ˣ�ϵͳĬ�ϵ��ø����޲ι��췽��super()����Ĭ�ϻ�������Ĺ��췽���еĵ�һ�м��ϸ�����޲ι��췽��
		this.cid = cid;
		this.cname = cname;
	}

	public Category() {
	}

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

	@Override
	public String toString() {
		return "Pategory [cid=" + cid + ", cname=" + cname + "]";
	}

}

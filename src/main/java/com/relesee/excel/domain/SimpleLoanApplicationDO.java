package com.relesee.excel.domain;

public class SimpleLoanApplicationDO extends MapperDO{
	    //申报号码
		private String a;
		//收款人类型
		private byte b;
		//个人身份证件号码
		private String c;
		//组织机构代码
		private String d;
		//收款人名称
		private String e;
		//付款人名称
		private String f;
		//收入款币种
		private String g;
		//收入款金额，以Long表示实际额度*100,展示时注意除以100
		private Long h;
		//结汇汇率
		private int i;
		//结汇金额,Long型乘100处理
		private Long j;
		//人民币账号/银行卡号
		private String k;
		//现汇金额
		private Long l;
		//外汇账号/银行卡号
		private String m;
		//其它金额
		private Long n;
		//其它账号/银行卡号
		private String o;
		//结算方式
		private char p;
		//银行业务编号
		private String q;
		//国内银行扣费币种
		private String r;
		//国内银行扣费金额
		private Long s;
		//国外银行扣费币种
		private String t;
		//国外银行扣费金额
		private Long u;
		//修改/删除原因
		private String v;
		//付款人常驻国家/地区代码
		private String w;
		//收款性质
		private String x;
		//交易编码1
		private String y;
		//相应金额1
		private Long z;
		//交易附言1
		private String aa;
		//交易编码2
		private String ab;
		//相应金额2
		private Long ac;
		//交易附言2
		private String ad;
		//是否保税货物项下收汇
		private boolean ae;
		//外汇局批件号/备案表好/业务编号
		private String af;
		//收入类型
		private String ag;
		//填报人
		private String ah;
		//填报人电话
		private String ai;
		//申报日期
		private String aj;
		//折美元金额
		private Long ak;
		//所属分行
		private String al;
		public String getA() {
			return a;
		}
		public void setA(String a) {
			this.a = a;
		}
		public byte getB() {
			return b;
		}
		public void setB(byte b) {
			this.b = b;
		}
		public String getC() {
			return c;
		}
		public void setC(String c) {
			this.c = c;
		}
		public String getD() {
			return d;
		}
		public void setD(String d) {
			this.d = d;
		}
		public String getE() {
			return e;
		}
		public void setE(String e) {
			this.e = e;
		}
		public String getF() {
			return f;
		}
		public void setF(String f) {
			this.f = f;
		}
		public String getG() {
			return g;
		}
		public void setG(String g) {
			this.g = g;
		}
		public Long getH() {
			return h;
		}
		public void setH(Long h) {
			this.h = h;
		}
		public int getI() {
			return i;
		}
		public void setI(int i) {
			this.i = i;
		}
		public Long getJ() {
			return j;
		}
		public void setJ(Long j) {
			this.j = j;
		}
		public String getK() {
			return k;
		}
		public void setK(String k) {
			this.k = k;
		}
		public Long getL() {
			return l;
		}
		public void setL(Long l) {
			this.l = l;
		}
		public String getM() {
			return m;
		}
		public void setM(String m) {
			this.m = m;
		}
		public Long getN() {
			return n;
		}
		public void setN(Long n) {
			this.n = n;
		}
		public String getO() {
			return o;
		}
		public void setO(String o) {
			this.o = o;
		}
		public char getP() {
			return p;
		}
		public void setP(char p) {
			this.p = p;
		}
		public String getQ() {
			return q;
		}
		public void setQ(String q) {
			this.q = q;
		}
		public String getR() {
			return r;
		}
		public void setR(String r) {
			this.r = r;
		}
		public Long getS() {
			return s;
		}
		public void setS(Long s) {
			this.s = s;
		}
		public String getT() {
			return t;
		}
		public void setT(String t) {
			this.t = t;
		}
		public Long getU() {
			return u;
		}
		public void setU(Long u) {
			this.u = u;
		}
		public String getV() {
			return v;
		}
		public void setV(String v) {
			this.v = v;
		}
		public String getW() {
			return w;
		}
		public void setW(String w) {
			this.w = w;
		}
		public String getX() {
			return x;
		}
		public void setX(String x) {
			this.x = x;
		}
		public String getY() {
			return y;
		}
		public void setY(String y) {
			this.y = y;
		}
		public Long getZ() {
			return z;
		}
		public void setZ(Long z) {
			this.z = z;
		}
		public String getAa() {
			return aa;
		}
		public void setAa(String aa) {
			this.aa = aa;
		}
		public String getAb() {
			return ab;
		}
		public void setAb(String ab) {
			this.ab = ab;
		}
		public Long getAc() {
			return ac;
		}
		public void setAc(Long ac) {
			this.ac = ac;
		}
		public String getAd() {
			return ad;
		}
		public void setAd(String ad) {
			this.ad = ad;
		}
		public boolean isAe() {
			return ae;
		}
		public void setAe(boolean ae) {
			this.ae = ae;
		}
		public String getAf() {
			return af;
		}
		public void setAf(String af) {
			this.af = af;
		}
		public String getAg() {
			return ag;
		}
		public void setAg(String ag) {
			this.ag = ag;
		}
		public String getAh() {
			return ah;
		}
		public void setAh(String ah) {
			this.ah = ah;
		}
		public String getAi() {
			return ai;
		}
		public void setAi(String ai) {
			this.ai = ai;
		}
		public String getAj() {
			return aj;
		}
		public void setAj(String aj) {
			this.aj = aj;
		}
		public Long getAk() {
			return ak;
		}
		public void setAk(Long ak) {
			this.ak = ak;
		}
		public String getAl() {
			return al;
		}
		public void setAl(String al) {
			this.al = al;
		}
		
}

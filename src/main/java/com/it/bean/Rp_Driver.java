package com.it.bean;

public class Rp_Driver {
	    private int rp_id_dri;//奖惩记录编号
	    private int dri_id;//驾驶员id
	    private double rp_addcheck_dr;//奖励金额
	    private double rp_subcheck_dr;//惩罚 金额
	    private String rp_month;//日期
		public int getRp_id_dri() {
			return rp_id_dri;
		}
		public void setRp_id_dri(int rp_id_dri) {
			this.rp_id_dri = rp_id_dri;
		}
		public int getDri_id() {
			return dri_id;
		}
		public void setDri_id(int dri_id) {
			this.dri_id = dri_id;
		}
		public double getRp_addcheck_dr() {
			return rp_addcheck_dr;
		}
		public void setRp_addcheck_dr(double rp_addcheck_dr) {
			this.rp_addcheck_dr = rp_addcheck_dr;
		}
		public double getRp_subcheck_dr() {
			return rp_subcheck_dr;
		}
		public void setRp_subcheck_dr(double rp_subcheck_dr) {
			this.rp_subcheck_dr = rp_subcheck_dr;
		}
		public String getRp_month() {
			return rp_month;
		}
		public void setRp_month(String rp_month) {
			this.rp_month = rp_month;
		}
		public Rp_Driver(int rp_id_dri, int dri_id, double rp_addcheck_dr, double rp_subcheck_dr, String rp_month) {
			super();
			this.rp_id_dri = rp_id_dri;
			this.dri_id = dri_id;
			this.rp_addcheck_dr = rp_addcheck_dr;
			this.rp_subcheck_dr = rp_subcheck_dr;
			this.rp_month = rp_month;
		}
		public Rp_Driver() {
			super();
			// TODO Auto-generated constructor stub
		}
		@Override
		public String toString() {
			return "Rp_Driver [rp_id_dri=" + rp_id_dri + ", dri_id=" + dri_id + ", rp_addcheck_dr=" + rp_addcheck_dr
					+ ", rp_subcheck_dr=" + rp_subcheck_dr + ", rp_month=" + rp_month + "]";
		}
		
}

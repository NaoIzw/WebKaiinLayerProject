package vo;

/* Code Generator Information.
 * generator Version 1.0.0 release 2007/10/10
 * generated Date Fri May 18 13:58:53 JST 2018
 */
import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

/**
 * KaiinVo.
 * @author naoyuki.izawa
 * @version 1.0
 * history
 * Symbol	Date		Person		Note
 * [1]		2018/05/18	naoyuki.izawa		Generated.
 */
public class KaiinVo implements Serializable{

	public static final String TABLE = "KAIIN";

	/**
	 * kaiinNo:int(10) <Primary Key>
	 */
	private int kaiinNo;

	/**
	 * Name:varchar(200)
	 */
	private String name;

	/**
	 * registDate:date(0)
	 */
	private Date registdate;

	/**
	* Constractor
	*/
	public KaiinVo(){}

	/**
	* Constractor
	* @param <code>kaiinno</code>
	*/
	public KaiinVo(int kaiinNo){
		this.kaiinNo = kaiinNo;
	}

	public int getKaiinNo(){ return this.kaiinNo; }

	public void setKaiinNo(int kaiinNo){ this.kaiinNo = kaiinNo; }

	public String getName(){ return this.name; }

	public void setName(String name){ this.name = name; }

	public java.sql.Date getRegistdate(){ return this.registdate; }

	public void setRegistdate(LocalDate registDate){ this.registdate = java.sql.Date.valueOf(registDate); }

	public void setRegistdate(Date registdate) { this.registdate = registdate; }


	public String toString(){
		StringBuffer buffer = new StringBuffer();
		buffer.append("[KaiinVo:");
		buffer.append(" kaiinno: ");
		buffer.append(kaiinNo);
		buffer.append(" name: ");
		buffer.append(name);
		buffer.append(" registdate: ");
		buffer.append(registdate);
		buffer.append("]");
		return buffer.toString();
	}


}

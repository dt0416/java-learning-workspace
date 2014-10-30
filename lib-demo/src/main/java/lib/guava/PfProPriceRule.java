package lib.guava;

import java.util.Date;

/**
 * <pre> PfProPriceRule </pre>
 * 
 * @author Ian Chen
 */
public class PfProPriceRule {
  
  /** The price rule id. */
  private Integer priceRuleId;

  /** The vend no. */
  private String vendNo;

  /** The chk price start. */
  private Integer chkPriceStart;

  /** The chk price end. */
  private Integer chkPriceEnd;

  /** The mark down. */
  private Integer markDown;

  /** The creator. */
  private String creator;

  /** The create dt. */
  private Date createDt;

  /** The moder. */
  private String moder;

  /** The mod dt. */
  private Date modDt;

  /**
   * Gets the price rule id.
   * 
   * @return the price rule id
   */
  public Integer getPriceRuleId() {
    return priceRuleId;
  }

  /**
   * Sets the price rule id.
   * 
   * @param priceRuleId the new price rule id
   */
  public void setPriceRuleId(Integer priceRuleId) {
    this.priceRuleId = priceRuleId;
  }

  /**
   * Gets the vend no.
   * 
   * @return the vend no
   */
  public String getVendNo() {
    return vendNo;
  }

  /**
   * Sets the vend no.
   * 
   * @param vendNo the new vend no
   */
  public void setVendNo(String vendNo) {
    this.vendNo = vendNo == null ? null : vendNo.trim();
  }

  /**
   * Gets the chk price start.
   * 
   * @return the chk price start
   */
  public Integer getChkPriceStart() {
    return chkPriceStart;
  }

  /**
   * Sets the chk price start.
   * 
   * @param chkPriceStart the new chk price start
   */
  public void setChkPriceStart(Integer chkPriceStart) {
    this.chkPriceStart = chkPriceStart;
  }

  /**
   * Gets the chk price end.
   * 
   * @return the chk price end
   */
  public Integer getChkPriceEnd() {
    return chkPriceEnd;
  }

  /**
   * Sets the chk price end.
   * 
   * @param chkPriceEnd the new chk price end
   */
  public void setChkPriceEnd(Integer chkPriceEnd) {
    this.chkPriceEnd = chkPriceEnd;
  }

  /**
   * Gets the mark down.
   * 
   * @return the mark down
   */
  public Integer getMarkDown() {
    return markDown;
  }

  /**
   * Sets the mark down.
   * 
   * @param markDown the new mark down
   */
  public void setMarkDown(Integer markDown) {
    this.markDown = markDown;
  }

  /**
   * Gets the creator.
   * 
   * @return the creator
   */
  public String getCreator() {
    return creator;
  }

  /**
   * Sets the creator.
   * 
   * @param creator the new creator
   */
  public void setCreator(String creator) {
    this.creator = creator == null ? null : creator.trim();
  }

  /**
   * Gets the creates the dt.
   * 
   * @return the creates the dt
   */
  public Date getCreateDt() {
    return createDt;
  }

  /**
   * Sets the creates the dt.
   * 
   * @param createDt the new creates the dt
   */
  public void setCreateDt(Date createDt) {
    this.createDt = createDt;
  }

  /**
   * Gets the moder.
   * 
   * @return the moder
   */
  public String getModer() {
    return moder;
  }

  /**
   * Sets the moder.
   * 
   * @param moder the new moder
   */
  public void setModer(String moder) {
    this.moder = moder == null ? null : moder.trim();
  }

  /**
   * Gets the mod dt.
   * 
   * @return the mod dt
   */
  public Date getModDt() {
    return modDt;
  }

  /**
   * Sets the mod dt.
   * 
   * @param modDt the new mod dt
   */
  public void setModDt(Date modDt) {
    this.modDt = modDt;
  }
}
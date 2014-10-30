/**
 * EZTRAVEL CONFIDENTIAL
 * 
 * @Package: lib.json.pojo
 * @FileName: PfProd.java
 * @author: ianchen
 * @date: 2014年10月1日, 下午2:33:38
 * 
 * <pre>
 *  Copyright 2013-2014 The ezTravel Co., Ltd. all rights reserved.
 *
 *  NOTICE:  All information contained herein is, and remains
 *  the property of ezTravel Co., Ltd. and its suppliers,
 *  if any.  The intellectual and technical concepts contained
 *  herein are proprietary to ezTravel Co., Ltd. and its suppliers
 *  and may be covered by TAIWAN and Foreign Patents, patents in 
 *  process, and are protected by trade secret or copyright law.
 *  Dissemination of this information or reproduction of this material
 *  is strictly forbidden unless prior written permission is obtained
 *  from ezTravel Co., Ltd.
 *  </pre>
 */
package lib.json.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * <pre> PfProd. </pre>
 *
 * @author Ian Chen
 */
public class PfProd {
//  @JsonProperty("PrdNo")
  private String prdNo;
  private MyJson myJson;

  public String getPrdNo() {
    return prdNo;
  }

  public void setPrdNo(String prdNo) {
    this.prdNo = prdNo;
  }

  public MyJson getMyJson() {
    return myJson;
  }

  public void setMyJson(MyJson myJson) {
    this.myJson = myJson;
  }
}

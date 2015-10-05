/**
 * EZTRAVEL CONFIDENTIAL
 * @Package:  ln.concurrent
 * @FileName: PrimeCallable.java
 * @author:   ianchen
 * @date:     2014年9月22日, 上午10:16:18
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
package ln.concurrent;

import java.util.concurrent.Callable;

/**
 * 1. 實作Callable
 * 2. override call()
 *
 * @author Ian Chen
 */
public class HelloCallable implements Callable<String> {

  String name;
  
  public HelloCallable(String name) {
    this.name = name;
  }
  
  @Override
  public String call() throws Exception {
    return "Hello " + name + "!!";
  }
}

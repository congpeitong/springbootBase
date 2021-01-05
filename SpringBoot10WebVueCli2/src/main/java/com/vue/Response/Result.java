package com.vue.Response;

/**
 * @Auther: MaleHunter
 * @Date: 2020/12/28 20:55
 * @Package: com.vue.Response
 * @CurrentProject: SpringBootBase
 * @version: 1.0
 */
public class Result {
  //响应码
  private int code;

  public Result(int code) {
    this.code = code;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }
}

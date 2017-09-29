package io.mycat.eye.web.dto;

/**
 * @ClassName: ExplainResultDto
 * @Description:执行计划结果对象
 * @author: 李平(360841519@qq.com)
 * @date: 2017年3月20日 上午10:16:47
 * 
 * @Copyright: 2017 www.mycat.io Inc. All rights reserved.
 */
public class ExplainResultDto {

  /**
   * 执行计划中查询的序列号
   */
  private Long id;

  /**
   * 查询类型
   */
  private String select_type;

  /**
   * 数据库中的表的名称
   */
  private String table;

  private String partitions;

  /**
   * 表访问方式
   */
  private String type;

  /**
   * 该查询可以利用的索引
   */
  private String possible_keys;

  /**
   * 使用的索引
   */
  private String key;

  /**
   * 被选中使用索引的索引键长度
   */
  private String key_len;

  /**
   * 列出是通过常量（const），还是某个表的某个字段（如果是join）来过滤（通过key）的
   */
  private String ref;

  /**
   * 通过系统收集到的统计信息估算出来的结果集记录条数
   */
  private Integer rows;


  private Integer filtered;

  /**
   * 查询中每一步实现的额外细节信息
   */
  private String Extra;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getSelect_type() {
    return select_type;
  }

  public void setSelect_type(String select_type) {
    this.select_type = select_type;
  }

  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  public String getPartitions() {
    return partitions;
  }

  public void setPartitions(String partitions) {
    this.partitions = partitions;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getPossible_keys() {
    return possible_keys;
  }

  public void setPossible_keys(String possible_keys) {
    this.possible_keys = possible_keys;
  }

  public String getKey() {
    return key;
  }

  public void setKey(String key) {
    this.key = key;
  }

  public String getKey_len() {
    return key_len;
  }

  public void setKey_len(String key_len) {
    this.key_len = key_len;
  }

  public String getRef() {
    return ref;
  }

  public void setRef(String ref) {
    this.ref = ref;
  }

  public Integer getRows() {
    return rows;
  }

  public void setRows(Integer rows) {
    this.rows = rows;
  }

  public Integer getFiltered() {
    return filtered;
  }

  public void setFiltered(Integer filtered) {
    this.filtered = filtered;
  }

  public String getExtra() {
    return Extra;
  }

  public void setExtra(String extra) {
    Extra = extra;
  }
}

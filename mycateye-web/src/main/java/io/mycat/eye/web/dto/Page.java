package io.mycat.eye.web.dto;


import java.io.Serializable;
import java.util.List;

/**
 * 数据分页组件
 * 
 * @author liping
 */
public class Page<T> implements Serializable {
	private static final long serialVersionUID = -5764853545343945831L;

	/**
	 * 当前分页的数据集
	 */
	private List<T> list;

	/**
	 * 总记录数
	 */
	private int totalCount;


	/**
	 * 当前页
	 */
	private int pageIndex;

	/**
	 * 每页记录数
	 */
	private int pageSize;


	/**
	 * 默认构造函数
	 */
	public Page() {
	}

	/**
	 * 构造函数
	 * 
	 * @param totalCount
	 *            总记录数
	 * @param pageIndex
	 * @param pageSize
	 * @param list
	 */
	public Page(int totalCount, int pageIndex, int pageSize, List<T> list) {
		this.totalCount = totalCount;
		this.pageIndex = pageIndex;
		this.pageSize = pageSize;
		this.list = list;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}


	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	@Override
	public String toString() {
		return "Page{" +
				"list=" + list +
				", totalCount=" + totalCount +
				", pageIndex=" + pageIndex +
				", pageSize=" + pageSize +
				'}';
	}
}

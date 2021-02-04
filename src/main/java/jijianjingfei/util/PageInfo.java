package jijianjingfei.util;

public class PageInfo {

	int pageIndex;// 起始位置，从第几条开始取
	int pageSize;// 每页取多少条
	int recordCount;// 总条数
	int pageCount;// 总页数

	public PageInfo() {
	}

	public PageInfo(int ppPageIndex, int ppPageSize, int ppRecordCount) {
		pageIndex = ppPageIndex;
		pageSize = ppPageSize;
		recordCount = ppRecordCount;
		pageCount = (recordCount % pageSize > 0) ? (recordCount / pageSize + 1)
				: (recordCount / pageSize);
	}

	public int getPageIndex() {
		return pageIndex;
	}

	public void setPageIndex(int pageIndex) {
		this.pageIndex = pageIndex;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getRecordCount() {
		return recordCount;
	}

	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
}

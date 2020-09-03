package accountbook.vo;

import java.util.Date;

public class AccountVO {

	private String name;
	private int expenses;
	private int income;
	private int total;
	private Date updateDate;
	private String history;
	
	public AccountVO() {}

	// 전부 받는 생성자 
	public AccountVO(String name, int expenses, int income, int total, Date updateDate, String history) {
		super();
		this.name = name;
		this.expenses = expenses;
		this.income = income;
		this.total = total;
		this.updateDate = updateDate;
		this.history = history;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the expenses
	 */
	public int getExpenses() {
		return expenses;
	}

	/**
	 * @param expenses the expenses to set
	 */
	public void setExpenses(int expenses) {
		this.expenses = expenses;
	}

	/**
	 * @return the income
	 */
	public int getIncome() {
		return income;
	}

	/**
	 * @param income the income to set
	 */
	public void setIncome(int income) {
		this.income = income;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}

	/**
	 * @return the updateDate
	 */
	public Date getUpdateDate() {
		return updateDate;
	}

	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	/**
	 * @return the history
	 */
	public String getHistory() {
		return history;
	}

	/**
	 * @param history the history to set
	 */
	public void setHistory(String history) {
		this.history = history;
	}

	@Override
	public String toString() {
		return "AccountVO [name=" + name + ", expenses=" + expenses + ", income=" + income + ", total=" + total
				+ ", updateDate=" + updateDate + ", history=" + history + "]";
	}
}

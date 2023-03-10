package entities;

import java.util.Objects;

public class Sale {

	private Integer month, year, items;
	private String seller;
	private Double total;

	public Sale(Integer month, Integer year, String seller, Integer items, Double total) {
		this.month = month;
		this.year = year;
		this.items = items;
		this.seller = seller;
		this.total = total;
	}

	public Integer getMonth() {
		return month;
	}

	public void setMonth(Integer month) {
		this.month = month;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getItems() {
		return items;
	}

	public void setItems(Integer items) {
		this.items = items;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Double averagePrice() {
		return total / items;
	}

	@Override
	public int hashCode() {
		return Objects.hash(items, month, seller, total, year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sale other = (Sale) obj;
		return Objects.equals(items, other.items) && Objects.equals(month, other.month)
				&& Objects.equals(seller, other.seller) && Objects.equals(total, other.total)
				&& Objects.equals(year, other.year);
	}

	@Override
	public String toString() {
		return month + "/" + year + ", " + seller + ", " + items + ", " + total + ", pm = ";
	}

}

package epam.booking_apartment.model;

import epam.booking_apartment.util.LocalDateToSqlDateConverter;

import javax.persistence.Convert;
import java.time.LocalDate;
import java.util.Date;

public class Apartment {

	private Long id;

	private String name;

	//@Convert(converter = LocalDateToSqlDateConverter.class)
	private Date date;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Apartment{" +
				"id=" + id +
				", name='" + name + '\'' +
				", date=" + date +
				'}';
	}
}

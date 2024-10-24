package org.primefaces.test;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import lombok.Data;

@Data
@Named
@ViewScoped
public class TestView implements Serializable {

	private String string;
	private Integer integer;
	private BigDecimal decimal;
	private LocalDateTime localDateTime;
	private List<TestObject> list;

	private Status currentStatus;

	@PostConstruct
	public void init() {
		string = "Welcome to PrimeFaces!!!";
		list = new ArrayList<>(Arrays.asList(new TestObject("Thriller", "Michael Jackson", 1982, Status.MY_SUCCESS),
				new TestObject("Back in Black", "AC/DC", 1980, Status.UNRESOLVED),
				new TestObject("The Bodyguard", "Whitney Houston", 1992, Status.MY_SUCCESS),
				new TestObject("The Dark Side of the Moon", "Pink Floyd", 1973, Status.FAILURE)));
	}

	public List<Status> getStatusList() {
		List<Status> statusList = new ArrayList<Status>();
		statusList.add(Status.MY_SUCCESS);
		statusList.add(Status.FAILURE);
		statusList.add(Status.UNRESOLVED);
		return statusList;
	}

	public List<TestObject> getDataList() {
		return this.list;
	}
}

package jp.imanaga.demo.spring.mvc.data;

import javax.validation.constraints.Size;

public class DemoBean {

	@Size(min = 3)
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

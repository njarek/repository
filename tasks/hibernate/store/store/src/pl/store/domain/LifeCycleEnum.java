package pl.store.domain;

public enum LifeCycleEnum {

	NEW("new"), MODIFIED("modified"), SENT("sent");

	private String lifecycle;

	private LifeCycleEnum(String lifecycle) {
		this.lifecycle = lifecycle;
	}

	public String getLifecycle() {
		return lifecycle;
	}

}

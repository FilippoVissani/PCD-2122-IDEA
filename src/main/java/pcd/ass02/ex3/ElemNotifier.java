package pcd.ass02.ex3;

import io.reactivex.rxjava3.core.ObservableEmitter;
import io.vertx.core.json.JsonObject;

public class ElemNotifier {

	static public final String NEW_PACKAGE_DECLARED = "new-package-declared";
	static public final String NEW_CLASS_FOUND = "new-class-found";
	static public final String NEW_INTERFACE_FOUND = "new-interface-found";
	static public final String NEW_METHOD_FOUND = "new-method-found";
	static public final String NEW_FIELD_FOUND = "new-field-found";

	private ObservableEmitter<JsonObject> stream;
	
	public ElemNotifier(ObservableEmitter<JsonObject> stream) {
		this.stream = stream;
	}

	public void notifyNewPackageDeclared(String name) {
		JsonObject msg = new JsonObject();
		msg
		.put("event", NEW_PACKAGE_DECLARED)
		.put("name", name);
		stream.onNext(msg);
	}

	public void notifyNewClass(String name) {
		JsonObject msg = new JsonObject();
		msg
		.put("event", NEW_CLASS_FOUND)
		.put("name", name);
		stream.onNext(msg);
	}

	public void notifyNewInterface(String name) {
		JsonObject msg = new JsonObject();
		msg
		.put("event", NEW_INTERFACE_FOUND)
		.put("name", name);
		stream.onNext(msg);
	}

	public void notifyNewField(String name) {
		JsonObject msg = new JsonObject();
		msg
		.put("event", NEW_FIELD_FOUND)
		.put("name", name);
		stream.onNext(msg);
	}

	public void notifyNewMethod(String name) {
		JsonObject msg = new JsonObject();
		msg
		.put("event", NEW_METHOD_FOUND)
		.put("name", name);
		stream.onNext(msg);
	}

}

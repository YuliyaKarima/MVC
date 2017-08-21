package fwk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * This class implements interface InvocationHandler that processes a method
 * invocation on a proxy instance and returns the result.
 * 
 * @author Другие
 *
 */
public class ModelInvocationHandler implements InvocationHandler {
	private Object obj;

	/**
	 * Constructor makes copy of the object being passed to it
	 * 
	 * @param f1
	 *            object is being copied
	 */
	public ModelInvocationHandler(Object f1) {
		obj = f1;
	}

	@Override
	public Object invoke(Object object, Method method, Object[] arg2) throws Throwable {
		// TODO Auto-generated method stub
		return method.invoke(obj, arg2);
	}

}

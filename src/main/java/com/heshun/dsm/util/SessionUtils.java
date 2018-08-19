package com.heshun.dsm.util;

import java.net.InetSocketAddress;
import java.util.HashMap;

import org.apache.http.util.TextUtils;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;

/**
 * 涉及到session操作的工具集合
 * 
 * @author huangxz
 * 
 */
public class SessionUtils {

	public static String getIpFromSession(IoSession session) {
		try {
			return ((InetSocketAddress) session.getRemoteAddress()).getAddress().getHostAddress();
		} catch (Exception e) {
			e.printStackTrace();
			return "dead connect";
		}
	}

	public static int getPortFromSession(IoSession session) {
		try {
			return ((InetSocketAddress) session.getRemoteAddress()).getPort();
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		}
	}

	// public static boolean bindDevices(String logotype, IoSession session)
	// throws NumberFormatException, IOException {
	// HashMap<Integer, Device> _config =
	// SystemHelper.loadDevicesByLogoType(Integer.valueOf(logotype));
	// if (_config == null)
	// return false;
	// session.setAttribute("devices", _config);
	// return true;
	// }
	public static void setLogoType(int logotype, IoSession session) {
		session.setAttribute("logotype", logotype);
	}

	public static void setLogoType(String logotype, IoSession session) {
		session.setAttribute("logotype", Integer.valueOf(logotype));
	}

	public static void bindLogoType(int logotype, IoSession session) {
		session.setAttribute("logotype", logotype);
	}

	public static boolean isSessionUnAvaliable(IoSession session) {
		return TextUtils.isEmpty(getIpFromSession(session));
	}

	public static boolean isSessionIllegal(IoSession s) {

		return TextUtils.isEmpty(getIpFromSession(s)) || getLogoType(s) == -1 || getDevices(s) == null;
	}

	public static void reset(IoSession session) {
		session.removeAttribute("logotype");
		session.removeAttribute("devices");
	}

	public static int getLogoType(IoSession session) {
		Object _logoType = session.getAttribute("logotype");
		if (_logoType == null) {
			return -1;
		} else {
			return (int) _logoType;
		}
	}

	@SuppressWarnings("unchecked")
	public static HashMap<Integer, Device> getDevices(IoSession session) {
		Object objDevices = session.getAttribute("devices");
		if (objDevices == null) {
			return null;
		} else {
			return (HashMap<Integer, Device>) objDevices;
		}
	}

	@SuppressWarnings("unchecked")
	public static HashMap<String, byte[]> getSwitchConfig(IoSession session) {

		Object config = session.getAttribute("switchconfig");
		if (config == null) {
			return null;
		} else {
			return (HashMap<String, byte[]>) config;
		}
	}

	public static void cacheSwitchConfig(HashMap<String, byte[]> result, IoSession s) {
		s.setAttribute("switchconfig", result);
	}

	public static long getLastWriteTime(IoSession s) {
		Object obj = s.getAttribute("writeTime");
		if (null == obj) {
			return 0;
		} else {
			return (long) obj;
		}
	}

	public static void setLastWriteTime(IoSession s) {
		s.setAttribute("writeTime", System.currentTimeMillis());
	}

}

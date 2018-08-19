package com.heshun.dsm.handler.strategy.eqa300.abt;

import com.alibaba.fastjson.JSONObject;
import com.heshun.dsm.entity.convert.AbsJsonConvert;
import com.heshun.dsm.util.Utils;

public class EQA300TConvert extends AbsJsonConvert<EQA300TPacket> {

	public EQA300TConvert(EQA300TPacket packet) {
		super(packet);
	}

	public int getPid() {
		return mPacket._pid;
	}

	/**
	 * 获取虚拟cpu
	 */
	public int getAddress() {
		return mPacket.address;
	}

	/**
	 * 获取波特率
	 */
	public int getPort() {
		return mPacket._port;
	}

	/**
	 * 获取接线方式(控制字)
	 */
	public int getWireType() {
		return mPacket._wireType;
	}

	/**
	 * 获取软件版本号
	 */
	public String getVersion() {
		return String.valueOf(mPacket._version);
	}

	/**
	 * A相电压
	 */
	public float getUa() {
		// 三相三线接法没有Uabc值
		if (mPacket._wireType == 1) {
			return 0;
		} else {
			return (float) ((double) mPacket._ua / 10000 * Math.pow(10, mPacket._dpt));
		}
	}

	/**
	 * B相电压
	 */
	public float getUb() {
		// 三相三线接法没有Uabc值
		if (mPacket._wireType == 1) {
			return 0;
		} else {
			return (float) ((double) mPacket._ub / 10000 * Math.pow(10, mPacket._dpt));
		}
	}

	/**
	 * C相电压
	 */
	public float getUc() {
		// 三相三线接法没有Uabc值
		if (mPacket._wireType == 1) {
			return 0;
		} else {
			return (float) ((double) mPacket._uc / 10000 * Math.pow(10, mPacket._dpt));
		}
	}

	/**
	 * ab相电压
	 */
	public float getUab() {
		return (float) ((double) mPacket._uab / 10000 * Math.pow(10, mPacket._dpt));
	}

	/**
	 * bc相电压
	 */
	public float getUbc() {
		return (float) ((double) mPacket._ubc / 10000 * Math.pow(10, mPacket._dpt));
	}

	/**
	 * ca相电压
	 */
	public float getUca() {
		return (float) ((double) mPacket._uca / 10000 * Math.pow(10, mPacket._dpt));
	}

	/**
	 * a相电流
	 */
	public float getIa() {
		return (float) ((double) mPacket._ia / 10000 * Math.pow(10, mPacket._dct));
	}

	/**
	 * b相电流
	 */
	public float getIb() {
		return (float) ((double) mPacket._ib / 10000 * Math.pow(10, mPacket._dct));
	}

	/**
	 * c相电流
	 */
	public float getIc() {
		return (float) ((double) mPacket._ic / 10000 * Math.pow(10, mPacket._dct));
	}

	// ADD
	/**
	 * 频率
	 */
	public float getFreq() {
		return (float) (double) mPacket._freq / 100;
	}

	/**
	 * A相有功功率
	 */
	public float getPa() {
		return (float) (((double) mPacket._pa / 10000) * Math.pow(10, mPacket._dqt));
	}

	/**
	 * B相有功功率
	 */
	public float getPb() {
		return (float) ((double) mPacket._pb / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * C相有功功率
	 */
	public float getPc() {
		return (float) ((double) mPacket._pc / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * 三相有功功率
	 */
	public float getPTotal() {
		return (float) ((double) mPacket._ptotal / 10000 * Math.pow(10, mPacket._dqt));
	}

	// ADD
	/**
	 * A相无功功率
	 */
	public float getQa() {
		return (float) (((double) mPacket._qa / 10000) * Math.pow(10, mPacket._dqt));
	}

	/**
	 * B相无功功率
	 */
	public float getQb() {
		return (float) ((double) mPacket._qb / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * C相无功功率
	 */
	public float getQc() {
		return (float) ((double) mPacket._qc / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * 三相无功功率
	 */
	public float getQTotal() {
		return (float) ((double) mPacket._qtotal / 10000 * Math.pow(10, mPacket._dqt));
	}

	// ADD
	/**
	 * A相视在功率
	 */
	public float getSa() {
		return (float) (((double) mPacket._sa / 10000) * Math.pow(10, mPacket._dqt));
	}

	/**
	 * B相视在功率
	 */
	public float getSb() {
		return (float) ((double) mPacket._sb / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * C相视在功率
	 */
	public float getSc() {
		return (float) ((double) mPacket._sc / 10000 * Math.pow(10, mPacket._dqt));
	}

	/**
	 * 三相视在功率
	 */
	public float getSTotal() {
		return (float) ((double) mPacket._stotal / 10000 * Math.pow(10, mPacket._dqt));
	}

	//
	/**
	 * A相功率因数
	 */
	public float getPFA() {
		return (float) ((double) mPacket._pfa / 1000);
	}

	/**
	 * B相功率因数
	 */
	public float getPFB() {
		return (float) ((double) mPacket._pfb / 1000);
	}

	/**
	 * C相功率因数
	 */
	public float getPFC() {
		return (float) ((double) mPacket._pfc / 1000);
	}

	/**
	 * 三相功率因数
	 */
	public float getPFTotal() {
		return (float) ((double) mPacket._pftotal / 1000);
	}

	public String getEpi() {
		return String.valueOf(Utils.bytes2Long(mPacket._epiHigh, mPacket._epiLow));
	}

	public String getEql() {
		return String.valueOf(Utils.bytes2Long(mPacket._eqlHigh, mPacket._eqlLow));
	}

	@Override
	public JSONObject toJsonObj(String ip) {

		JSONObject _json = super.toJsonObj(ip);
		_json.put("address", getAddress());
		_json.put("pid", getPid());
		_json.put("control", getWireType());
		_json.put("version", getVersion());
		_json.put("ua", getUa());
		_json.put("ub", getUb());
		_json.put("uc", getUc());
		_json.put("uab", getUab());
		_json.put("ubc", getUbc());
		_json.put("uca", getUca());
		_json.put("ia", getIa());
		_json.put("ib", getIb());
		_json.put("ic", getIc());
		// ADD
		_json.put("freq", getFreq());

		_json.put("pa", getPa());
		_json.put("pb", getPb());
		_json.put("pc", getPc());
		_json.put("pt", getPTotal());
		// ADD
		_json.put("qa", getQa());
		_json.put("qb", getQb());
		_json.put("qc", getQc());
		_json.put("qt", getQTotal());
		// ADD
		_json.put("sa", getSa());
		_json.put("sb", getSb());
		_json.put("sc", getSc());
		_json.put("st", getSTotal());
		// ADD
		_json.put("pfa", getPFA());
		_json.put("pfb", getPFB());
		_json.put("pfc", getPFC());
		_json.put("pft", getPFTotal());
		_json.put("epi", getEpi());
		_json.put("eql", getEql());
		return _json;
	}

	@Override
	public String getType() {
		return "eqa300";
	}

}
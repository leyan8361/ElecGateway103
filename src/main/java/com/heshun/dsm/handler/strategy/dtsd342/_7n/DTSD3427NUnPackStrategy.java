package com.heshun.dsm.handler.strategy.dtsd342._7n;

import java.util.Map;

import org.apache.mina.core.buffer.IoBuffer;
import org.apache.mina.core.session.IoSession;

import com.heshun.dsm.entity.Device;
import com.heshun.dsm.entity.ResultWrapper;
import com.heshun.dsm.handler.helper.PacketInCorrectException;
import com.heshun.dsm.handler.helper.UnRegistSupervisorException;
import com.heshun.dsm.handler.strategy.AbsDeviceUnpackStrategy;
import com.heshun.dsm.util.Utils;

public class DTSD3427NUnPackStrategy extends AbsDeviceUnpackStrategy<DTSD3427NConvert, DTSD3427NPacket> {

	public DTSD3427NUnPackStrategy(IoSession session, IoBuffer in, Device d) {
		super(session, in, d);
	}

	@Override
	public DTSD3427NConvert getConvert(DTSD3427NPacket packet) {
		return new DTSD3427NConvert(packet);
	}

	@Override
	public String getDeviceType() {
		return "DTSD3427N";
	}

	private short getShortValue(byte[] _singleData) {
		byte high, low;
		high = _singleData[0];
		low = _singleData[1];

		return (short) (Utils.bytes2Short(high, low) & 0xFFFF);
	}

	@Override
	protected DTSD3427NPacket handleTotalQuery(int size, Map<Integer, ResultWrapper> ycData,
			Map<Integer, ResultWrapper> yxData, Map<Integer, ResultWrapper> ymData) throws PacketInCorrectException,
			UnRegistSupervisorException {
		DTSD3427NPacket p = new DTSD3427NPacket(mDevice.vCpu);
		try {
			p.set_ua(getShortValue(ycData.get(1).getOriginData()));
			p.set_ub(getShortValue(ycData.get(2).getOriginData()));
			p.set_uc(getShortValue(ycData.get(3).getOriginData()));
			//
			p.set_uab(getShortValue(ycData.get(5).getOriginData()));
			p.set_ubc(getShortValue(ycData.get(6).getOriginData()));
			p.set_uca(getShortValue(ycData.get(7).getOriginData()));
			//
			p.set_ia(getShortValue(ycData.get(9).getOriginData()));
			p.set_ib(getShortValue(ycData.get(10).getOriginData()));
			p.set_ic(getShortValue(ycData.get(11).getOriginData()));
			// p.set_in(getShortValue(ycData.get(13)));
			//
			p.set_pa(getShortValue(ycData.get(14).getOriginData()));
			p.set_pb(getShortValue(ycData.get(15).getOriginData()));
			p.set_pc(getShortValue(ycData.get(16).getOriginData()));
			p.set_ptotal(getShortValue(ycData.get(17).getOriginData()));
			//
			p.set_qa(getShortValue(ycData.get(18).getOriginData()));
			p.set_qb(getShortValue(ycData.get(19).getOriginData()));
			p.set_qc(getShortValue(ycData.get(20).getOriginData()));
			p.set_qtotal(getShortValue(ycData.get(21).getOriginData()));
			//
			p.set_sa(getShortValue(ycData.get(22).getOriginData()));
			p.set_sb(getShortValue(ycData.get(23).getOriginData()));
			p.set_sc(getShortValue(ycData.get(24).getOriginData()));
			p.set_stotal(getShortValue(ycData.get(25).getOriginData()));
			//
			p.set_pfa(getShortValue(ycData.get(26).getOriginData()));
			p.set_pfb(getShortValue(ycData.get(27).getOriginData()));
			p.set_pfc(getShortValue(ycData.get(28).getOriginData()));
			p.set_pftotal(getShortValue(ycData.get(29).getOriginData()));
			//
			p.set_freq(getShortValue(ycData.get(30).getOriginData()));
			//
			p.setEpiHigh(ycData.get(31).getOriginData());
			p.setEpiLow(ycData.get(32).getOriginData());
			p.set_eqlHigh(ycData.get(33).getOriginData());
			p.set_eqlLow(ycData.get(34).getOriginData());
		} catch (NullPointerException e) {
			throw new PacketInCorrectException();
		}
		return p;
	}

}

package com.heshun.modbus.util;

import java.util.Arrays;

public class Testtt {
	public static void main(String[] args) {
		fetchRequest(4, 4, (short) 15, (short) 12);
		fetchRequest(1, 4, (short) 342, (short) 12);
	}

	public static void fetchRequest(int pid, int funcCode, short start, short offset) {
		byte[] request = new byte[] { (byte) pid, (byte) funcCode };
		request = Arrays.copyOf(request, 6);

		byte[] _start = ByteUtils.shortToByte2(start);
		byte[] _offset = ByteUtils.shortToByte2(offset);
		
		request[2] = _start[0];
		request[3] = _start[1];
		request[4] = _offset[0];
		request[5] = _offset[1];

		System.out.println(Arrays.toString(request));
		

		// return updateWithCrc16(request);

	}
}

ew byte[1024];//ª∫≥Â¥Û–°
			int len=-1;//
			while((len=in.read(flush))!=-1) {
				out.write(flush,0,len);
			}
			out.flus
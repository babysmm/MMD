package com.mmd.mmdshop.services;

import java.util.List;

import com.mmd.mmdshop.dbdo.ShowDDO;

public interface ShowService {
	
	List<ShowDDO> findNewShow();
	
}

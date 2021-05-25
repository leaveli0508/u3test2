package cn.kgc.demo.service.imp;

import cn.kgc.demo.pojo.Sale;
import cn.kgc.demo.service.SaleService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = false)
public class SaleServiceImpl extends BaseServiceImpl<Sale> implements SaleService {
}

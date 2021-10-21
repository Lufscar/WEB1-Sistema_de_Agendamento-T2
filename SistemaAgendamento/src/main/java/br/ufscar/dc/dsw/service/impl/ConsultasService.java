package br.ufscar.dc.dsw.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import br.ufscar.dc.dsw.dao.IConsultasDAO;
import br.ufscar.dc.dsw.domain.Consultas;
import br.ufscar.dc.dsw.service.spec.IConsultasService;

@Service
@Transactional(readOnly = false)
public class ConsultasService implements IConsultasService {

	@Autowired
	IConsultasDAO dao;

	public void salvar(Consultas consulta) {
		dao.save(consulta);
	}

	public void excluir(Long id) {
		dao.deleteById(id);
	}

	@Transactional(readOnly = true)
	public Consultas buscarPorId(Long id) {
		return dao.findById(id.longValue());
	}

	@Transactional(readOnly = true)
	public List<Consultas> buscarTodos() {
		return dao.findAll();
	}

}

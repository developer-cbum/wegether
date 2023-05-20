package com.wegether.app.service.project;

import com.wegether.app.dao.ProjectDAO;
import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.vo.ProjectVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDAO projectDAO;
    @Override
    public List<ProjectDTO> getList() {
        return projectDAO.projectfindAll();
    }

    @Override
    public void Write(ProjectVO projectVO) {
        projectDAO.projectSave(projectVO);
    }

    @Override
    public Optional<ProjectDTO> read(Long id) {
        return projectDAO.findById(id);
    }

    @Override
    public void modify(ProjectVO projectVO) {
        projectDAO.setProjectDTO(toDTO(projectVO));
    }

    @Override
    public void remove(Long id) {
        projectDAO.ProjectDelete(id);
    }
}

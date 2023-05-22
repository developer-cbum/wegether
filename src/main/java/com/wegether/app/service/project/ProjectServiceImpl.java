package com.wegether.app.service.project;

import com.wegether.app.dao.ProjectDAO;
import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.dto.ProjectPagination;
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
    public List<ProjectDTO> getList(ProjectPagination projectPagination) {
        return projectDAO.projectFindAll(projectPagination);
    }

    @Override
    public void write(ProjectDTO projectDTO) {
        projectDAO.projectSave(projectDTO);
    }



    @Override
    public Optional<ProjectDTO> getProject(Long id) {
        return projectDAO.findById(id);
    }

    @Override
    public void modify(ProjectDTO projectDTO) {
        projectDAO.setProjectDTO(toDTO(projectDTO));
    }

    @Override
    public void remove(Long id) {
        projectDAO.ProjectDelete(id);
    }

    @Override
    public int getTotal() {
        return projectDAO.findCountOfProject();
    }
}

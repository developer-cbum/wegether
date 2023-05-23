package com.wegether.app.service.project;

import com.wegether.app.dao.FileDAO;
import com.wegether.app.dao.ProjectDAO;
import com.wegether.app.dao.ProjectFileDAO;
import com.wegether.app.domain.dto.DataDTO;
import com.wegether.app.domain.dto.ProjectDTO;
import com.wegether.app.domain.dto.ProjectPagination;
import com.wegether.app.domain.vo.DataFileVO;
import com.wegether.app.domain.vo.ProjectFileVO;
import com.wegether.app.domain.vo.ProjectVO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectDAO projectDAO;
    private final FileDAO fileDAO;
    private final ProjectFileDAO projectFileDAO;


//    @Override
//    public List<ProjectDTO> getList(ProjectPagination projectPagination) {
//        return projectDAO.projectFindAll(projectPagination);
//    }
//
//    @Override
//    public void write(ProjectDTO projectDTO) {
//        projectDAO.projectSave(projectDTO);
//    }



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

    @Override
    @Transactional(rollbackFor = Exception.class)
    public List<ProjectDTO> getList(ProjectPagination projectPagination) {
        final List<ProjectDTO> projects = projectDAO.projectFindAll(projectPagination);
        projects.forEach(project -> project.setFiles(fileDAO.projectFindAll(project.getId())));
        return projects;
    }

    //    자료 등록 - 파일
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void write(ProjectDTO projectDTO) {
        projectDAO.projectSave(projectDTO);
        projectDTO.getFiles().forEach(file -> {
            file.setProjectId(projectDTO.getId());
            fileDAO.save(file);
        });
        projectDTO.getFiles().forEach(projectFileDTO -> {
            ProjectFileVO projectFileVO = new ProjectFileVO();
            projectFileVO.setId(projectFileDTO.getId());
            projectFileVO.setProjectId(projectFileDTO.getProjectId());
            projectFileDAO.save(projectFileVO);
        });
    }

//    @Override
//    @Transactional(rollbackFor = Exception.class)
//    public Optional<ProjectDTO> read(Long id) {
//        final Optional<ProjectDTO> foundProject = projectDAO.findById(id);
//        if(foundProject.isPresent()){
//            foundProject.get().setFiles(fileDAO.projectFindAll(foundProject.get().getId()));
//        }
//        return foundProject;
//    }

}

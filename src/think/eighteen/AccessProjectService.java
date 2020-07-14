package think.eighteen;

import java.io.IOException;
import java.util.Map;

/**
 * @author z
 */
public interface AccessProjectService {
    /**
     * employee project user pass
     * @param employeeNumber employee number
     * @param projectId project id
     * @return map
     */
    Map<String, String> getEmployeeProjectUserPassMap(String employeeNumber, int projectId);

    /**
     * access project
     * @param employeeNumber employee number
     * @param project project
     * @param httpServletResponse httpServletResponse
     * @throws IOException access io
     */
    void accessProject(String employeeNumber, String project, HttpServletResponse httpServletResponse) throws IOException;
}

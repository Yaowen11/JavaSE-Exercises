package think.eighteen;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.HashMap;
import java.util.Map;

/**
 * @author z
 */
public class AccessImpl implements AccessProjectService {

    private String name;

    private String password;

    public AccessImpl() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Map<String, String> getEmployeeProjectUserPassMap(String employeeNumber, int projectId) {
        return null;
    }

    @Override
    public void accessProject(String employeeNumber, String project, HttpServletResponse httpServletResponse) throws IOException {

    }

    private void attendanceAccess(String employeeNumber, HttpServletResponse httpServletResponse) {
        System.out.printf("employee number %s, httpServletResponse class %s\n", employeeNumber, httpServletResponse.getClass().getSimpleName());
    }
    private void oa33Access(String employeeNumber, String project, HttpServletResponse httpServletResponse) {
        System.out.printf("employeeNumber %s, project %s HttpServletResponse class %s: \n", employeeNumber, project, httpServletResponse.getClass().getSimpleName());
    }
    private void oa66Access(String employeeNumber, String project, HttpServletResponse httpServletResponse) {
        System.out.printf("employeeNumber %s, project %s HttpServletResponse class %s: \n", employeeNumber, project, httpServletResponse.getClass().getSimpleName());
    }
    public static void dump() {}
    public static void main(String[] args) {
        AccessImpl access = new AccessImpl();
        Method[] methods = access.getClass().getDeclaredMethods();
        String[] projects = {"oa33", "oa66", "attendance"};
        String employeeNumber = "121212121";
        Map<String, Method> methodMap = new HashMap<>();
        for (Method method : methods) {
            if (method.getName().contains("Access")) {
                methodMap.put(method.getName(), method);
            }
        }
        for (String project : projects) {
            Method projectMethod = methodMap.get(project + "Access");
            Parameter[] parameters = projectMethod.getParameters();
            for (Parameter parameter : parameters) {
                System.out.println(parameter.getName() + parameter.toString());
            }
            System.out.println(projectMethod.getParameterCount());
//            try {
//                projectMethod.invoke(access, employeeNumber, project, new HttpServletResponse());
//            } catch (IllegalAccessException | InvocationTargetException e) {
//                e.printStackTrace();
//            }
        }
    }
}

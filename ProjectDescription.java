import java.util.List;
import java.util.ArrayList;

// Class representing the project description
 class pDescription {
    private String name;
    private String comment;
    private List<String> projects;
    private List<BuildCommand> buildSpec;
    private List<String> natures;
    private List<FilteredResource> filteredResources;

    public pDescription(String name, String comment) {
        this.name = name;
        this.comment = comment;
        this.projects = new ArrayList<>();
        this.buildSpec = new ArrayList<>();
        this.natures = new ArrayList<>();
        this.filteredResources = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<BuildCommand> getBuildSpec() {
        return buildSpec;
    }

    public List<String> getNatures() {
        return natures;
    }

    public List<FilteredResource> getFilteredResources() {
        return filteredResources;
    }
}

// BuildCommand class
class BuildCommand {
    private String name;
    private List<String> arguments;

    public BuildCommand(String name) {
        this.name = name;
        this.arguments = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}

// FilteredResource class
class FilteredResource {
    private String id;
    private String name;
    private int type;
    private CustomMatcher matcher;

    public FilteredResource(String id, int type, CustomMatcher matcher) {
        this.id = id;
        this.type = type;
        this.matcher = matcher;
    }
}

// CustomMatcher class
class CustomMatcher {
    private String id;
    private String arguments;

    public CustomMatcher(String id, String arguments) {
        this.id = id;
        this.arguments = arguments;
    }
}

// Main class
public class ProjectDescription {
    public static void main(String[] args) {
        // Matcher setup
        CustomMatcher matcher = new CustomMatcher(
                "org.eclipse.core.resources.regexFilterMatcher",
                "node_modules|\\.git|__CREATED_BY_JAVA_LANGUAGE_SERVER__"
        );

        // Filtered resource setup
        FilteredResource filteredResource = new FilteredResource("1744561676724", 30, matcher);

        // Build commands
        BuildCommand command1 = new BuildCommand("org.eclipse.jdt.core.javabuilder");
        BuildCommand command2 = new BuildCommand("org.eclipse.wst.common.project.facet.core.builder");
        BuildCommand command3 = new BuildCommand("org.eclipse.wst.validation.validationbuilder");
        BuildCommand command4 = new BuildCommand("org.eclipse.m2e.core.maven2Builder");

        // Project description
        pDescription project = new pDescription("HospitalManagementSystem", "");

        // Add build commands
        project.getBuildSpec().add(command1);
        project.getBuildSpec().add(command2);
        project.getBuildSpec().add(command3);
        project.getBuildSpec().add(command4);

        // Add natures
        project.getNatures().add("org.eclipse.jem.workbench.JavaEMFNature");
        project.getNatures().add("org.eclipse.wst.common.modulecore.ModuleCoreNature");
        project.getNatures().add("org.eclipse.jdt.core.javanature");
        project.getNatures().add("org.eclipse.m2e.core.maven2Nature");
        project.getNatures().add("org.eclipse.wst.common.project.facet.core.nature");
        project.getNatures().add("org.eclipse.wst.jsdt.core.jsNature");

        // Add filtered resources
        project.getFilteredResources().add(filteredResource);

        // Output
        System.out.println("Project Name: " + project.getName());
        System.out.println("Build Commands:");
        for (BuildCommand command : project.getBuildSpec()) {
            System.out.println("- " + command.getName());
        }
    }
}



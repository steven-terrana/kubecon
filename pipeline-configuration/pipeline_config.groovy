allow_scm_jenkinsfile = false 

libraries{
  sdp{
    images{
      registry = "https://docker.pkg.github.com"
      repository = "boozallen/sdp-images"
      cred = "github"
    }
  }
  github{
     source_type = "github"
  }
  pytest
  owasp_dep_check
  sonarqube
  docker{
    registry = "docker.pkg.github.com"
    repo_path_prefix = "steven-terrana/dummy-vuln-app" 
    cred = "github" 
  }
  sysdig_secure{
    cred = "sysdig-secure-api"
  }
  kubernetes{
    k8s_credential = "kubeconfig"
    helm_configuration_repository = "https://github.com/steven-terrana/dummy-vuln-app"
    helm_configuration_repository_branch = "main"
    helm_configuration_repository_credential = "github" 
    helm_configuration_repository_start_path = "chart"
    k8s_context = "default-context"
    promote_previous_image = false 
  }
  owasp_zap{
    target = "http://prod-dummy-vuln-app:5000/static/index.html"
  }
  google_lighthouse{
    url = "http://prod-dummy-vuln-appo:5000/static/html"
  }
}

application_environments{
  prod
}

template_methods{
  unit_test
  static_code_analysis
  application_dependency_scan
  penetration_testing
  accessibility_compliance_scan
}

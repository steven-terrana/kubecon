allow_scm_jenkinsfile = false 

libraries{
  sdp{
    images{
      registry = "https://docker.pkg.github.com"
      repository = "boozallen/sdp-images"
      cred = "githubpublic"
    }
  }
  github{
     source_type = "github"
  }
  pytest
  owasp_dep_check
  sonarqube{
    installation_name = "sonarqube"
  }
  docker{
    registry = "docker.pkg.github.com"
    repo_path_prefix = "steven-terrana/dummy-vuln-app" 
    cred = "sterrana" 
  }
  kubernetes{
    k8s_credential = "kubeconfig"
    helm_configuration_repository = "https://github.com/steven-terrana/dummy-vuln-app"
    helm_configuration_repository_branch = "main"
    helm_configuration_repository_credential = "sterrana" 
    helm_configuration_repository_start_path = "chart"
    k8s_context = "default-context"
    promote_previous_image = false 
  }
  owasp_zap{
    target = "http://prod-dummy-vuln-app:5000/static/index.html"
  }
  google_lighthouse{
    url = "http://prod-dummy-vuln-appo:5000/static/index.html"
  }
}

application_environments{
  prod
}

template_methods{
  unit_test
  static_code_analysis
  scan_container_image
  application_dependency_scan
  penetration_testing
  accessibility_compliance_scan
}

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
    helm_configuration_repository = "https://github.com/steven-terrana/sysdig-webinar" 
    helm_configuration_repository_credential = "github" 
    k8s_context = "service-account-context"
    promote_previous_image = false 
  }
  owasp_zap{
    target = "http://54.172.14.65:31165"
  }
  google_lighthouse{
    url = "http://54.172.14.65:31165"
  }
}

application_environments{
  prod
}

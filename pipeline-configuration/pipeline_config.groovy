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
  owasp_dep_check
  sonarqube
  docker{
    registry = "docker.pkg.github.com"
    repo_path_prefix = "steven-terrana/nginx-echo" 
    cred = "github" 
  }
  sysdig_secure{
    cred = "sysdig-secure-api"
  }
  kubernetes{
    k8s_credential = "kubeconfig"
    helm_configuration_repository = "https://github.com/steven-terrana/nginx-echo"
    helm_configuration_repository_branch = "main"
    helm_configuration_repository_credential = "github" 
    helm_configuration_repository_start_path = "chart"
    k8s_context = "default-context"
    promote_previous_image = false 
  }
  owasp_zap{
    target = "http://nginx-echo:5000"
  }
  google_lighthouse{
    url = "http://nginx-echo:5000"
  }
}

application_environments{
  prod
}

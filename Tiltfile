SOURCE_IMAGE = os.getenv("SOURCE_sdsdIMAGE", default='us-central1-docker.pkg.dev/samp-tap/gcp-lab/tanzu-java-web-app')
LOCAL_PATH = os.getenv("LOCAL_PATH", default='local-path')
NAMESPACE = os.getenv("NAMESPACE", default='default')
OUTPUT_TO_NULL_COMMAND = os.getenv("OUTPUT_TO_NULL_COMMAND", default=' > /dev/null ')

k8s_custom_deploy(
  'workload-name',
  apply_cmd="tanzu apps workload apply -f path-to-workload-yaml --debug --live-update" +
    " --local-path " + LOCAL_PATH +
    " --source-image us-central1-docker.pkg.dev/samp-tap/gcp-lab/tanzu-java-web-app" +
    " --namespace " + NAMESPACE +
    " --yes " +
    OUTPUT_TO_NULL_COMMAND + 
    " && kubectl get workload workload-name --namespace " + NAMESPACE + " -o yaml",
  delete_cmd="tanzu apps workload delete -f path-to-workload-yaml --namespace " + NAMESPACE + " --yes" ,
  deps=['pom.xml', './target/classes'],
  container_selector='workload',
  live_update=[
    sync('./target/classes', '/workspace/BOOT-INF/classes')
  ]
)

k8s_resource('workload-name', port_forwards=["8080:8080"],
  extra_pod_selectors=[{'carto.run/workload-name': 'workload-name', 'app.kubernetes.io/component':'run'}])

allow_k8s_contexts('gke_samp-tap_us-central1_tap-cluster-2')

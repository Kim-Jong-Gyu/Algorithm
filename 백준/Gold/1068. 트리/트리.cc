#include <bits/stdc++.h>
using namespace std;

int n, node, root, r;
vector<int> v[54];

int dfs(int here){
    int ret = 0;
    int child = 0;
    for(int there : v[here]){
        if(there == r) continue;
        ret += dfs(there);
        child++;
    }
    if(child == 0) return 1;
    return ret;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> node;
        if(node == -1) root = i;
        else v[node].push_back(i);
    }
    cin >> r;
    if(r == root){
        cout << 0 << '\n';
        return 0;
    }
    else{
        cout << dfs(root) << '\n';
    }
    return 0;
}
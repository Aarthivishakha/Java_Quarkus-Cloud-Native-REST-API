"""Report churn from this repository's real Git history."""
import sys
from collections import defaultdict
from pydriller import Repository

churn = defaultdict(lambda: {"commits": 0, "added": 0, "removed": 0})
for commit in Repository(sys.argv[1]).traverse_commits():
    for change in commit.modified_files:
        path = change.new_path or change.old_path
        if path:
            churn[path]["commits"] += 1
            churn[path]["added"] += change.added_lines
            churn[path]["removed"] += change.deleted_lines
print(dict(churn))

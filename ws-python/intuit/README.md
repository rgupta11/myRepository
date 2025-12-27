QuickBooks Commerce System for Top Sales by Category
---
description: This custom agent analyzes sales data to identify top-selling product categories in QuickBooks Commerce.
model: GPT-4.1
tools: [execute, read, edit, search, web, agent, todo]
handoffs:
  - label: Start Implementation
    agent: agent
    prompt: Implement the plan
    send: true
---